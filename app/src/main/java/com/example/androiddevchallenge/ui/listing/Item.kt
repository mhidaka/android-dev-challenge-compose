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
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.content.Cat
import com.example.androiddevchallenge.content.Contributor
import com.example.androiddevchallenge.repository.post1
import com.example.androiddevchallenge.repository.post3

@Composable
private fun PostImage(cat: Cat, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(cat.imageThumbId),
        contentDescription = null, // decorative
        modifier = modifier
            .size(60.dp, 60.dp)
            .clip(RoundedCornerShape(percent = 50))
    )
}

@Composable
private fun PostTitle(cat: Cat) {
    Text(cat.title, style = MaterialTheme.typography.subtitle1)
}

@Composable
private fun ContributorWithSelfIntroduction(
    contributor: Contributor,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            val textStyle = MaterialTheme.typography.body2
            Text(
                text = contributor.name,
                style = textStyle
            )
            Text(
                text = " - ${contributor.shortIntroduction}",
                style = textStyle
            )
        }
    }
}

@Composable
fun Item(cat: Cat, onSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onSelected(cat.id) }
    ) {
        PostImage(cat, Modifier.padding(end = 16.dp))
        Column(modifier = Modifier.weight(1f)) {
            PostTitle(cat)
            ContributorWithSelfIntroduction(cat.contributor)
        }
    }
}

@Preview("Item")
@Composable
fun ItemPreview() {
    ThemedPreview {
        Item(post1) {
        }
    }
}

@Preview("Item - dark theme")
@Composable
fun ItemDarkmodePreview() {
    ThemedPreview(darkTheme = true) {
        Item(post3) {
        }
    }
}
