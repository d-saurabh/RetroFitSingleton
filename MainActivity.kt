package com.example.recipefinderapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipefinderapp.R
import com.example.recipefinderapp.data.Recipe
import com.example.recipefinderapp.data.RecipePayload
import com.example.recipefinderapp.model.RecipeListAdapter
import com.example.recipefinderapp.networking.RetrofitClient
import kotlinx.android.synthetic.main.activity_recipe_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeList : AppCompatActivity() {
    var layoutManager: RecyclerView.LayoutManager? = null
    var list: ArrayList<Recipe>? = null
    var adapter: RecipeListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        var defaultIngredients= "onions"
        var defaultSearchTerm="omelet"
        var extras = intent.extras
        var ingredients = extras!!.getString("ingredients")
        var searchTerm = extras!!.getString("searchterm")
        if (extras != null && !ingredients.equals("")
            && !searchTerm.equals("")
        ) {
            defaultIngredients = ingredients!!
            defaultSearchTerm = searchTerm!!
        }
        getRecipes(defaultIngredients, defaultSearchTerm)
    }
    
    // method to call the api using the Retrofit client 
    private fun getRecipes(i: String, q: String) {
        list = ArrayList()
        RetrofitClient.instance.get(i,q).enqueue(object :
            Callback<RecipePayload> {
            override fun onFailure(call: Call<RecipePayload>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<RecipePayload>,
                response: Response<RecipePayload>
            ) {
                list = response.body()?.results
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = RecipeListAdapter(applicationContext, list!!)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
                adapter!!.notifyDataSetChanged()
            }
        })
    }
}
