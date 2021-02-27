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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ThemedPreview
import com.example.androiddevchallenge.content.Cat
import com.example.androiddevchallenge.content.Contributor
import com.example.androiddevchallenge.repository.post1
import com.example.androiddevchallenge.repository.post6

@Composable
fun FeaturedItem(cat: Cat, modifier: Modifier = Modifier) {
    val typography = MaterialTheme.typography
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val imageModifier = Modifier
            .heightIn(min = 180.dp, max = 180.dp)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)
        Image(
            painter = painterResource(cat.imageId),
            contentDescription = null, // decorative
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = cat.title,
            style = typography.h6
        )

        Spacer(Modifier.height(16.dp))

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Row() {
                Image(
                    painter = painterResource(cat.contributor.imageId),
                    contentDescription = null, // decorative
                    modifier = modifier
                        .padding(end = 16.dp)
                        .size(45.dp, 45.dp)
                        .clip(RoundedCornerShape(percent = 50))
                )
                ContributorsComment(cat.contributor)
            }
        }
    }
}

@Composable
private fun ContributorsComment(contributor: Contributor) {
    val typography = MaterialTheme.typography
    Column() {
        Text(
            text = contributor.shortIntroduction,
            style = typography.body2
        )
        Text(
            text = "${contributor.name} - 2 minutes left",
            style = typography.body2
        )
    }
}

@Preview("Featured Item")
@Composable
fun FeaturedItemPreview() {
    ThemedPreview {
        FeaturedItem(cat = post1)
    }
}

@Preview("Featured Item Dark theme")
@Composable
fun FeaturedItemDarkThemePreview() {
    ThemedPreview(darkTheme = true) {
        FeaturedItem(cat = post6)
    }
}
