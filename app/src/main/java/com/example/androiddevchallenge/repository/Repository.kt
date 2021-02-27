package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.content.Cat

interface Repository {
    suspend fun getPost(postId: String): Result<Cat>
    suspend fun getPosts(): Result<List<Cat>>
}