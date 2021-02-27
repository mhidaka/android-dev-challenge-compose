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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.androiddevchallenge.content.Cat
import com.example.androiddevchallenge.repository.FakeAdaptionRepository
import com.example.androiddevchallenge.repository.Result
import kotlinx.coroutines.runBlocking

@Composable
fun Detail(catId: String, onUpPress: () -> Unit) {
    val cat =
        remember(catId) { (runBlocking { FakeAdaptionRepository().getPost(catId) } as Result.Success).data }
    Detail(cat = cat, onUpPress = onUpPress)
}

@Composable
private fun Detail(cat: Cat, onUpPress: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = cat.title) },
                navigationIcon = {
                    IconButton(onClick = onUpPress) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        }
    ) {
        DetailItem(cat = cat)
    }
}
