package com.example.pokedexapp.repository

import com.example.pokedexapp.utils.Resource
import com.example.pokedexapp.data.remote.PokemonApi
import com.example.pokedexapp.data.remote.responses.Pokemon
import com.example.pokedexapp.data.remote.responses.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Something Went Wrong")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("Something Went Wrong")
        }
        return Resource.Success(response)
    }
}