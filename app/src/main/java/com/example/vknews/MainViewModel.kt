package com.example.vknews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vknews.domain.FeedPost
import com.example.vknews.domain.StatisticItem

class MainViewModel : ViewModel() {

    private val initialFeedPostList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val _feedPostList = MutableLiveData<List<FeedPost>>(initialFeedPostList)
    val feedPostList: LiveData<List<FeedPost>> = _feedPostList

    fun updateCount(item: StatisticItem, feedPost: FeedPost) {
        val modifiedList = _feedPostList.value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll{ post->
            if (post == feedPost) {
                val oldStatistics = post.statistics
                val newStatistics = oldStatistics.toMutableList().apply {
                    replaceAll { oldItem ->
                        if (oldItem.type == item.type) {
                            oldItem.copy(count = oldItem.count + 1)
                        } else {
                            oldItem
                        }
                    }
                }
                post.copy(statistics = newStatistics)
            } else {
                post
            }
        }
        _feedPostList.value = modifiedList
    }

    fun delete(feedPost: FeedPost) {
        val modifiedList = _feedPostList.value?.toMutableList() ?: mutableListOf()
        modifiedList.remove(feedPost)
        _feedPostList.value = modifiedList
    }

//    private val _feedPost = MutableLiveData(FeedPost())
//    val feedPost: LiveData<FeedPost> = _feedPost

//    fun updateCount(item: StatisticItem) {
//        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
//        val newStatistics = oldStatistics.toMutableList().apply {
//            replaceAll { oldItem ->
//                if (oldItem.type == item.type) {
//                    oldItem.copy(count = oldItem.count + 1)
//                } else {
//                    oldItem
//                }
//            }
//        }
//        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
//    }

}