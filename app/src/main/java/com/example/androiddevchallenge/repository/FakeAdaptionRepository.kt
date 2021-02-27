package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.content.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FakeAdaptionRepository : Repository {

    override suspend fun getPost(postId: String): Result<Cat> = withContext(Dispatchers.IO) {
        val post = posts.find { it.id == postId }
        if (post == null) {
            Result.Error(IllegalArgumentException("Unable to find post"))
        } else {
            Result.Success(post)
        }
    }

    override suspend fun getPosts(): Result<List<Cat>> {
        return Result.Success(posts)
    }
}