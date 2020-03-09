package com.rizieq.submission1

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import com.bumptech.glide.Glide
import com.rizieq.submission1.MainActivity.ListItemUI.Companion.idImage
import com.rizieq.submission1.MainActivity.ListItemUI.Companion.idName
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val INTENT_TO_DETAIL = "detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val dataModel : Data = intent.getParcelableExtra(INTENT_TO_DETAIL)
        DetailUI(dataModel).setContentView(this)


    }
    class DetailUI(val dataModel: Data) : AnkoComponent<DetailActivity> {
        lateinit var imgDetail: ImageView
        lateinit var tvTitle: TextView
        lateinit var tvDetail: TextView

        var idImg: Int = 1
        val idTitle = 2
        val idTvDetail = 3


        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout {
                imgDetail = imageView {
                    adjustViewBounds = true
                    id = idImg
                    Glide.with(this)
                        .load(dataModel.image)
                        .into(this)

                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(50f)


                }


                tvTitle = textView {
                    id = idTitle
                    gravity = Gravity.CENTER
                    setTypeface(Typeface.DEFAULT_BOLD)
                    textSize = 24f
                    text = dataModel.name
                    right = 20


                }.lparams(dip(matchParent), dip(matchParent)) {
                    below(imgDetail)
                    topMargin = dip(20f)
                    centerHorizontally()

                }

                tvDetail = textView {
                    padding = dip(16f)
                    text = dataModel.detail


                }.lparams(dip(matchParent), dip(matchParent)) {
                    topMargin = dip(10f)
                    below(tvTitle)
                }
            }

        }
    }
}
