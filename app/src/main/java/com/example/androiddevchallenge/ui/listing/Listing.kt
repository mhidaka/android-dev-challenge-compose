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
package com.example.androiddevchallenge.ui.listing

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ThemedPreview
import com.example.androiddevchallenge.content.Cat
import com.example.androiddevchallenge.repository.FakeAdaptionRepository
import com.example.androiddevchallenge.repository.Result
import com.example.androiddevchallenge.repository.post1
import com.example.androiddevchallenge.ui.ItemList
import kotlinx.coroutines.runBlocking

@Composable
fun Listing(featuredCat: Cat, cats: List<Cat>, onSelected: (String) -> Unit) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = stringResource(R.string.app_name)
                    )
                },
            )
        }
    ) {
        ListingContent(featuredCat, cats, onSelected)
    }
}

@Composable
private fun ListingContent(featuredCat: Cat, cats: List<Cat>, onSelected: (String) -> Unit) {
    LazyColumn {
        item { FeaturedItemTitle() }
        item { FeaturedItem(cat = featuredCat, onSelected) }
        item { ItemListTitle() }
        item { ItemList(cats = cats, onSelected = onSelected) }
    }
}

@Composable
private fun FeaturedItemTitle() {
    Text(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
        text = "Recent cats for you",
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
private fun ItemListTitle() {
    Text(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
        text = "Wonderful cute cats",
        style = MaterialTheme.typography.subtitle1
    )
}

@Preview("Listing screen", widthDp = 360, heightDp = 640)
@Composable
fun ListingPreview() {
    ThemedPreview {
        val cats = runBlocking { FakeAdaptionRepository().getPosts() }
        Listing(post1, (cats as Result.Success).data) {
        }
    }
}

@Preview("Listing screen dark theme", widthDp = 360, heightDp = 640)
@Composable
fun ListingDarkThemePreview() {
    ThemedPreview(darkTheme = true) {
        val cats = runBlocking { FakeAdaptionRepository().getPosts() }
        Listing(post1, (cats as Result.Success).data) {
        }
    }
}
