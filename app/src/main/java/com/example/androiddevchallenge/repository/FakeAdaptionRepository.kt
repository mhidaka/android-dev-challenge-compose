/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
