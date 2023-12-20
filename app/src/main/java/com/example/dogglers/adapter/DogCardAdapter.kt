/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.model.Dog

/**
 * Адаптер для розширення макета відповідного елемента списку та заповнення подання інформацією
 * з відповідного джерела даних
 */
class DogCardAdapter(
    private val context: Context,
    private val layout: Int,
    private val dataset: List<Dog>
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    class DogCardViewHolder(private val item:View): RecyclerView.ViewHolder(item) {
        //Оголосити та ініціалізувати всі компоненти інтерфейсу користувача елемента списку
        val imageDog: ImageView = item.findViewById(R.id.dog_image)
        val nameDog: TextView = item.findViewById(R.id.dog_name)
        val ageDog: TextView = item.findViewById(R.id.dog_age)
        val hobbiesDog: TextView = item.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.

        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.

        val inflater = LayoutInflater.from(parent.context)
        val layoutResId =
            if (layout == Layout.GRID)
                R.layout.grid_list_item
            else
                R.layout.vertical_horizontal_list_item
        val view = inflater.inflate(layoutResId, parent, false)

        return DogCardViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {

        val dog = dataset[position]

        // Встановити ресурс зображення для поточної собаки
        holder.imageDog.setImageResource(dog.imageResourceId)

        // Встановити текст для поточного імені собаки
        holder.nameDog.text = dog.name

        // Встановити текст для поточного віку собаки
        holder.ageDog.text = context.resources?.getString(R.string.dog_age, dog.age)

        // Встановити текст для поточного хобі собаки
        holder.hobbiesDog.text = context.resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
