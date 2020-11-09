package com.example.kotlin.h2

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.setVisibility
import com.example.kotlin.showToastLong
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    private lateinit var adapter: ImagesAdapter
    private var urlArray: ArrayList<String> = arrayListOf(
        "https://vitamin-mir.ru/images/virtuemart/product/s1200.jpg",
        "https://i.pinimg.com/736x/b5/ed/27/b5ed27930f68d86ffebc53e945f082a4.jpg",
        "https://i.pinimg.com/originals/2b/a3/e4/2ba3e41374427027f99eeedb4c93206f.jpg",
        "https://avatars.mds.yandex.net/get-pdb/964102/682da809-0980-4ca1-be09-7301c96312aa/s1200?webp=false",
        "https://i.pinimg.com/originals/2b/a3/e4/2ba3e41374427027f99eeedb4c93206f.jpg")

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        createRecycler()
        onDelClick()
        onAddClick()
    }

    private fun createRecycler() {
        adapter = ImagesAdapter(urlArray)
        images_rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        images_rv.adapter = adapter
    }

    private fun onAddClick() {
        add_btn.setOnClickListener(View.OnClickListener {
            setVisibility(add_layout,View.VISIBLE)
             setUrl()
        })
    }

    private fun setUrl() {
        addImg_btn.setOnClickListener(View.OnClickListener {
            val newUrl = editImage.text.toString()
            if(newUrl.startsWith("https://")){
                urlArray.add(newUrl)
                adapter.notifyDataSetChanged()
                setVisibility(add_layout,View.INVISIBLE)}
            else {this.showToastLong("Данный URL добавить нельзя, попробуйте добавить URL начинающийся с HTTPS")}
        })
    }

    private fun onDelClick() {
        delete_btn.setOnClickListener(View.OnClickListener {
            if (urlArray.size == 1) {
                this.showToastLong("Can not delete image")
            } else {
                val deletingPos = adapter.holder.adapterPosition
                setAnimation(deletingPos)
                urlArray.removeAt(deletingPos)
            }
        })
    }

    private fun setAnimation(deletingPos:Int) {
        val animator = ObjectAnimator.ofFloat(adapter.holder.itemView,View.ROTATION,-360f,0f)
        adapter.notifyItemRemoved(deletingPos)
        animator.duration=500
        animator.start()
    }
}


