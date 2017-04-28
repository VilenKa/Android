package com.example.vilev.taxiapp42.Activities

import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.vilev.taxiapp42.Activities.DiversListActivity.DriversListActivity
import com.example.vilev.taxiapp42.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.location.places.Places
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.map_activity.*
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.maps.model.LatLngBounds

/**
 * Created by vilev on 24.04.2017.
 */
class MapActivity : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {


    override fun onConnectionFailed(connectionResult: ConnectionResult) {}


    val PLACE_AUTOCOMPLETE_REQUEST_CODE : Int = 1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_activity)
        this.orderBtn.setOnClickListener(this)
        this.backBtn.setOnClickListener(this)
        this.findBtn.setOnClickListener(this)

        var mGoogleApiClient = GoogleApiClient.Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build()

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.backBtn-> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            R.id.orderBtn -> {
                startActivity(Intent(this, DriversListActivity::class.java))
            }
            R.id.findBtn->{
                try {
                    val intent = PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build(this)
                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE)
                } catch (e: GooglePlayServicesRepairableException) {
                    // TODO: Handle the error.
                } catch (e: GooglePlayServicesNotAvailableException) {
                    // TODO: Handle the error.
                }

            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
      //  map.addMarker(MarkerOptions().position(LatLng(0.0, 0.0)).title("Marker"))

      //  var mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient)
        var myPosition = LatLng(55.1644, 61.4368)
        val builder = CameraPosition.Builder()
        builder.zoom(17f)
        builder.target(myPosition)
        map.moveCamera((CameraUpdateFactory.newCameraPosition(builder.build())))
        //     }



    }
}