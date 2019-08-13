package com.rybarstudios.galleryapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ContentResolver
import android.content.Context
import androidx.annotation.AnyRes
import com.rybarstudios.galleryapp.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewList = mutableListOf<ImageView>()
        val imageNameList = arrayOf("adventure_automobile_classic_2533092",
            "aerial_photography_aerial_shot_aerial_view_2583847",
            "afterglow_beach_cliff_2555285",
            "alley_architecture_buildings_2526517",
            "architectural_design_architecture_bridge_2540653",
            "bloom_blossom_flora_2567011",
            "close_up_colorful_colors_2529148",
            "clouds_coconut_trees_daylight_2486168",
            "colorful_colourful_houses_2501965",
            "wallpaper_astronomy_astrophotography_2538107",
            "abstract_abstract_expressionism_art_2505693",
            "beautiful_breathtaking_canada_day_2526105")

        //Create 10 empty ImageViews
        for (i in 0..11) {
            imageViewList.add(i, ImageView(this))
        }

        //Add images to ImageViews and assign content descriptions
        imageViewList[0].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.adventure_automobile_classic_2533092
            )
        )
        imageViewList[0].contentDescription = "Classic automobile"
        imageViewList[1].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.aerial_photography_aerial_shot_aerial_view_2583847
            )
        )
        imageViewList[1].contentDescription = "Aerial photography"
        imageViewList[2].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.afterglow_beach_cliff_2555285
            )
        )
        imageViewList[2].contentDescription = "Beach cliff"
        imageViewList[3].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.alley_architecture_buildings_2526517
            )
        )
        imageViewList[3].contentDescription = "Architecture"
        imageViewList[4].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.architectural_design_architecture_bridge_2540653
            )
        )
        imageViewList[4].contentDescription = "Bridge architecture"
        imageViewList[5].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.bloom_blossom_flora_2567011
            )
        )
        imageViewList[5].contentDescription = "Flower"
        imageViewList[6].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.close_up_colorful_colors_2529148
            )
        )
        imageViewList[6].contentDescription = "Colorful shoes"
        imageViewList[7].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.clouds_coconut_trees_daylight_2486168
            )
        )
        imageViewList[7].contentDescription = "Coconut trees"
        imageViewList[8].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.colorful_colourful_houses_2501965
            )
        )
        imageViewList[8].contentDescription = "Colorful houses"
        imageViewList[9].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.wallpaper_astronomy_astrophotography_2538107
            )
        )
        imageViewList[9].contentDescription = "Astronomy"
        imageViewList[10].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.abstract_abstract_expressionism_art_2505693
            )
        )
        imageViewList[10].contentDescription = "Abstract expressionism"
        imageViewList[11].setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.beautiful_breathtaking_canada_day_2526105
            )
        )
        imageViewList[11].contentDescription = "Breathtaking Canada Day"

        val layoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        imageViewList.forEachIndexed { index, imageView ->
            imageViewList[index].layoutParams = layoutParams
            imageViewList[index].adjustViewBounds = true
            imageViewList[index].setPadding(15, 15, 15, 15)
            when {
                index % 2 != 0 -> left_column.addView(imageViewList[index])
                else -> right_column.addView(imageViewList[index])
            }

            Log.i("TAG", imageViewList[index].toString())

            imageViewList[index].setOnClickListener {
                val imageUri: Uri = getUriToDrawable(this,
                    resources
                        .getIdentifier(imageNameList[index],
                            "drawable",
                            this.packageName))
                val intent = Intent(this, FullscreenActivity::class.java)
                intent.putExtra("image", imageUri.toString())
                startActivity(intent)
            }
        }
    }

     fun getUriToDrawable(context: Context,
                          @AnyRes drawableId:Int):Uri {
         return Uri.parse(
             ContentResolver.SCHEME_ANDROID_RESOURCE +
             "://" + context.getResources().getResourcePackageName(drawableId)
             + '/'.toString() + context.getResources().getResourceTypeName(drawableId)
             + '/'.toString() + context.getResources().getResourceEntryName(drawableId)
         )
}
}
