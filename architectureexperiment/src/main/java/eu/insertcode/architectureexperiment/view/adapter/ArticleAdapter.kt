/*
 *    Copyright 2018 Maarten de Goede
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

package eu.insertcode.architectureexperiment.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import eu.insertcode.architectureexperiment.R
import eu.insertcode.architectureexperiment.data.Article
import eu.insertcode.architectureexperiment.view.activity.ArchitectureComponentsActivity
import eu.insertcode.architectureexperiment.view.fragment.ArticleFragment
import kotlinx.android.synthetic.main.item_article.view.*

/**
 * Created by maartendegoede on 18/06/2018.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class ArticleAdapter(
        private val activity: ArchitectureComponentsActivity,
        private val articles: List<Article>
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false).apply {
                setOnClickListener { v ->
                    if (v.tag is Int) activity.showFragment(ArticleFragment.newInstance(v.tag as Int), true)
                }
            })

    override fun getItemCount() = articles.count() * 3

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.view.tag = position % articles.count()
        holder.bind(articles[position % articles.count()])
    }

    class ArticleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(article: Article) {
            view.arch_article_title.text = article.title
            view.arch_article_subtitle.text = article.article
            Glide.with(view)
                    .load(article.thumbnailUrl)
                    .into(view.arch_article_thumbnail)
        }
    }
}