package org.hyperskill.aquarium

import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import org.hyperskill.aquarium.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.extras

        val images = intent?.getStringArrayList("imageAnimals") ?:
        listOf(getString(R.string.image_koi_carp) , getString(R.string.image_spiny_dogfish) , getString(R.string.image_kaluga))

        val names = intent?.getStringArrayList("nameAnimals") ?:
        listOf(getString(R.string.koi_carp), getString(R.string.spiny_dogfish), getString(R.string.kaluga))

        val descriptions = intent?.getStringArrayList("descriptionAnimals") ?: listOf(
            //Koi Carp
            "These colorful, ornamental fish are a variety of the Amur carp. " +
                    "They were originally found in Central Europe and Asia, " +
                    "but they’ve spread to many other parts of the world. " +
                    "Koi carp are popular with breeders, and there are currently over 100 varieties " +
                    "created through breeding.\n" +
                    "\n" +
                    "The average age of a koi carp can vary based on the part of the world it’s bred in. " +
                    "Carps bred outside of Japan have an average lifespan of around 15 years," +
                    " while carps bred in Japan can live 40 years or more. The oldest koi carp on record," +
                    " which was a fish named Hanako, reportedly lived for 226 years!",

            // Spiny dogfish
            "The spiny dogfish is a type of shark with venomous spines in front of its dorsal fins." +
                    " Not only is it an aggressive hunter, but these fish are known to hunt in packs!" +
                    " Like many shark species, these fish grow slowly, " +
                    "and some females don’t reach full maturity until they’re over 30 years old.\n" +
                    "\n" +
                    "While the lifespan of the spiny dogfish is already impressive, " +
                    "some fish live for far longer than average. " +
                    "Spiny dogfish in the Pacific Ocean tend to live longer than fish in the Atlantic," +
                    " with some fish living longer than 80 years. " +
                    "Females tend to mature later than males, and they usually live longer too.",

            //Kaluga
            "Sometimes called the river beluga, the kaluga is a type of predatory sturgeon." +
                    " While these fish spend the majority of their time in freshwater, " +
                    "they’re also able to survive in salt water. " +
                    "The kaluga is one of the world’s largest freshwater fish species and can grow to be more than 18 feet long, " +
                    "with a weight of over 2,200 pounds.\n" +
                    "\n" +
                    "Kalugas are overfished, which has left the species vulnerable to extinction. " +
                    "Although many kaluga are killed before they fully mature, " +
                    "these fish have the potential to live very long lives. " +
                    "One kaluga that was caught in China is estimated to be over 100 years old."
        )

        val viewPager2 = findViewById<ViewPager2>(R.id.viewpager2)
        val pagerAdapter = PageAdapter(images, names, descriptions)
        viewPager2.adapter = pagerAdapter
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = names[position]
        }.attach()
    }
}