/*
 * Copyright (C) 2019 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.balloondemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.BalloonCompose

class ComposeActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      val context = LocalContext.current
      val balloon = Balloon.Builder(context)
        .setArrowSize(10)
        .setWidthRatio(1.0f)
        .setHeight(BalloonSizeSpec.WRAP)
        .setArrowOrientation(ArrowOrientation.BOTTOM)
        .setArrowPosition(0.5f)
        .setPadding(12)
        .setMarginHorizontal(12)
        .setTextSize(15f)
        .setCornerRadius(8f)
        .setTextColorResource(R.color.white_87)
        .setIconDrawableResource(R.drawable.ic_edit)
        .setBackgroundColorResource(R.color.skyBlue)
        .setOnBalloonDismissListener {
          Toast.makeText(context, "dismissed", Toast.LENGTH_SHORT).show()
        }
        .setBalloonAnimation(BalloonAnimation.ELASTIC)

      Box(modifier = Modifier.fillMaxSize()) {
        BalloonCompose(
          modifier = Modifier.align(Alignment.Center),
          builder = balloon,
          balloonContent = {
            Text(
              modifier = Modifier.padding(12.dp),
              text = "Helloooooooooo!\nnice to meet youuuuu\nqweqweqweqwe",
              color = Color.White
            )
          }
        ) {
          Button(
            modifier = Modifier.size(120.dp, 75.dp),
            onClick = {
              it.showAtCenter()
            }
          ) {
            Text(text = "click")
          }
        }
      }
    }
  }
}
