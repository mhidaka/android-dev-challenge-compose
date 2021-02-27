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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Item
import com.example.androiddevchallenge.ThemedPreview
import com.example.androiddevchallenge.content.Cat
import com.example.androiddevchallenge.repository.FakeAdaptionRepository
import com.example.androiddevchallenge.repository.Result
import kotlinx.coroutines.runBlocking

@Composable
fun ItemList(
    cats: List<Cat>,
    onSelected: (String) -> Unit
) {
    Column {
        cats.forEach { cat ->
            Item(cat = cat, onSelected = onSelected)
            ListDivider()
        }
    }
}

@Composable
private fun ListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Preview("Home screen", widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    ThemedPreview {
        val cats = runBlocking { FakeAdaptionRepository().getPosts() }
        ItemList((cats as Result.Success).data) {

        }
    }
}

@Preview("Home screen dark theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkThemePreview() {
    ThemedPreview(darkTheme = true) {
        val cats = runBlocking { FakeAdaptionRepository().getPosts() }
        ItemList((cats as Result.Success).data) {

        }
    }
}
