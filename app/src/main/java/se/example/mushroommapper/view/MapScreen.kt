package se.example.mushroommapper.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import se.example.mushroommapper.model.Places
import se.example.mushroommapper.viewModel.HomeViewModel


@Composable
fun MapScreen(
    homeViewModel: HomeViewModel,
) {

    val homeUIState = homeViewModel.homeUIState
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit){
        homeViewModel.loadPlaces()
    }

    val places = mutableListOf<Places>()

    for(place in homeUIState.placesList.data ?: emptyList()){
        places.add(Places(place.userId,place.title, place.description,place.latitude,place.longitude))
    }
    //val mostRecentPosition

    val singapore = LatLng(1.35, 103.87)
    /*val l1 = "1.30"
    val l2 = "103.84"
    val places = listOf(
        Places("Singapore","Nice city", "cool city",1.36,103.87),
        Places("Singapore2","Nice city", "cool city",1.39,103.87),
        Places("Singapore3","Nice city", "cool city",1.42,103.87),
        Places("Singapore4","Nice city", "cool city",l1.toDouble(),l2.toDouble()),
    )*/


    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        for(place in places) {
            Marker(
                state = MarkerState(position = LatLng(place.latitude, place.longitude)),
                title = place.title,
                snippet = place.description,
            )
        }
    }
}