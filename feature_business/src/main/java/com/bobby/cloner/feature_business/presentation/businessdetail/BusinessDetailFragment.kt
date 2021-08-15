package com.bobby.cloner.feature_business.presentation.businessdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bobby.cloner.core.presentation.utils.viewBinding
import com.bobby.cloner.feature_business.R
import com.bobby.cloner.feature_business.databinding.FragmentBusinessDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class BusinessDetailFragment : Fragment(R.layout.fragment_business_detail), OnMapReadyCallback {

    private var locationMap: GoogleMap? = null

    private val binding: FragmentBusinessDetailBinding by viewBinding(FragmentBusinessDetailBinding::bind)

    companion object {
        fun newInstance() = BusinessDetailFragment()
    }

    private lateinit var viewModel: BusinessDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObserver()
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        locationMap = googleMap
    }

    override fun onDestroyView() {
        locationMap?.clear()
        super.onDestroyView()
    }

    private fun setupView() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.fcv_map_location) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setupObserver() {
        viewModel.locationMap.observe(viewLifecycleOwner) { (title, coordinates) ->
            updateLocationMap(title, coordinates)
        }
    }

    private fun updateLocationMap(title: String, coordinates: LatLng) {
        locationMap?.let {
            it.uiSettings.isScrollGesturesEnabled = false
            it.uiSettings.isZoomGesturesEnabled = false
            it.addMarker(MarkerOptions().position(coordinates).title(title))
            pointToPosition(coordinates)
        }
    }

    private fun pointToPosition(position: LatLng) {
        val cameraPosition = CameraPosition.Builder()
            .target(position)
            .zoom(17f).build()
        locationMap?.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

}