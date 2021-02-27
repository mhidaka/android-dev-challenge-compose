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

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.content.Cat
import com.example.androiddevchallenge.content.Contributor

val yanzm = Contributor("yanzm", "https://twitter.com/yanzm", "心の友", R.drawable.icon1)
val mhidaka = Contributor("mhidaka", "https://twitter.com/mhidaka", "ひつじ牧場のほうから来ました", R.drawable.icon2)
val mochico1 = Contributor("mochico", "https://twitter.com/_mochicon_", "DDD本から飛び出ました", R.drawable.icon3)
val mochico2 = Contributor("mochico", "https://twitter.com/_mochicon_", "悩ましいもちこです", R.drawable.icon4)
val tacksman = Contributor("taksman", "https://twitter.com/tacksman", "DDD本ではパスを出す役です", R.drawable.icon5)
val vvakame = Contributor("vvakame", "https://twitter.com/vvakame", "家にふわふわちゃんがいます", R.drawable.icon6)

val post1 = Cat(
    id = "71afcdf1-10fe-4142-92ca-240d9a4c1566",
    title = "とてもかわいいねこちゃん",
    description = "",
    contributor = vvakame,
    imageId = R.drawable.cat1,
    imageThumbId = R.drawable.cat1_thumbnail
)

val post2 = Cat(
    id = "e4aaf068-130c-432c-a949-3387c5885ad2",
    title = "すばらしくうつくしいねこちゃん",
    description = "",
    contributor = tacksman,
    imageId = R.drawable.cat2,
    imageThumbId = R.drawable.cat2_thumbnail
)

val post3 = Cat(
    id = "8ca83258-f94f-44b2-a861-5c4e161b2d13",
    title = "すーぱークールなねこちゃん",
    description = "",
    contributor = mochico2,
    imageId = R.drawable.cat3,
    imageThumbId = R.drawable.cat3_thumbnail
)

val post4 = Cat(
    id = "13745e90-450e-44f7-b69a-f6fd9127e312",
    title = "ねこ？だろうか？？",
    description = "",
    contributor = mochico1,
    imageId = R.drawable.cat4,
    imageThumbId = R.drawable.cat4_thumbnail
)

val post5 = Cat(
    id = "13745e90-450e-44f7-b69a-f6fd9127e312",
    title = "神々しいねこちゃん",
    description = "",
    contributor = mhidaka,
    imageId = R.drawable.cat5,
    imageThumbId = R.drawable.cat5_thumbnail
)

val post6 = Cat(
    id = "df36f752-7745-4387-b8cf-421dc79ac49c",
    title = "あまえてるねこちゃん",
    description = "",
    contributor = yanzm,
    imageId = R.drawable.cat6,
    imageThumbId = R.drawable.cat6_thumbnail
)

val posts: List<Cat> =
    listOf(
        post1,
        post2,
        post3,
        post4,
        post5,
        post6,
        post1,
        post2,
        post3,
        post4,
        post5,
        post6
    )
