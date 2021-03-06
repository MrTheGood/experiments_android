/*
 *    Copyright 2019 Maarten de Goede
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.insertcode.experiment.designcommentsexperiment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.insertcode.experiment.designcommentsexperiment.data.DemoContent
import eu.insertcode.multiplethemes.R
import kotlinx.android.synthetic.main.activity_flat_commentlist.*

class FlatCommentlistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_commentlist)

        design_comments.adapter = CommentsAdapter().apply {
            submitList(DemoContent.comments)
        }
    }
}
