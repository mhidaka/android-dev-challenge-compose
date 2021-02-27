package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.content.Cat

class FakeAdaptionRepository : Repository{
    override suspend fun getPost(postId: String): Result<Cat> {
        TODO("Not yet implemented")
    }

    override suspend fun getPosts(): Result<List<Cat>> {
        TODO("Not yet implemented")
    }
}