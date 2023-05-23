package com.dyrelosh.pethotels.presentation.ui.user.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.databinding.FragmentMapBinding
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import com.yandex.mapkit.*
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.directions.driving.DrivingOptions
import com.yandex.mapkit.directions.driving.DrivingRoute
import com.yandex.mapkit.directions.driving.DrivingRouter
import com.yandex.mapkit.directions.driving.DrivingSession
import com.yandex.mapkit.directions.driving.VehicleOptions
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.runtime.Error


class MapFragment : UserBaseFragment(), DrivingSession.DrivingRouteListener {
    override val showBottomNavigationView = false

    lateinit var binding: FragmentMapBinding
    lateinit var mapView: MapView
    lateinit var myLocation: UserLocationLayer
    private val START_ROAD = Point(54.187191048526, 45.181758977308)
    private val END_ROUTE = Point(54.216958, 45.103892)
    private val SCREEN_CENTER = Point(
        (START_ROAD.latitude + END_ROUTE.latitude) / 2,
        (START_ROAD.longitude + END_ROUTE.latitude) / 2
    )
    private var mapObjects: MapObjectCollection? = null
    private var drivingRouter: DrivingRouter? = null
    private var drivingSession: DrivingSession? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        mapView = binding.hotelMapContainer

        MapKitFactory.initialize(requireContext())

        mapView.map.move(  //стартвая точка
            CameraPosition(Point(54.187191048526, 45.181758977308), 18.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5F),
            null
        )
        val point = Point(54.187191048526, 45.181758977308)
        mapView.map.mapObjects.addPlacemark(point)


        var mapKit = MapKitFactory.getInstance()

//        var probki = mapKit.createTrafficLayer(mapView.mapWindow)
//        var probkiIsOn = false

//        binding.myLocationButton.setOnClickListener {
//            when (probkiIsOn) {
//                false -> {
//                    probkiIsOn = true
//                    probki.isTrafficVisible = true
//                }
//                true -> {
//                    probkiIsOn = false
//                    probki.isTrafficVisible = false
//                }
//            }
//        }

        //моя локация
        myLocation = mapKit.createUserLocationLayer(mapView.mapWindow)
        myLocation.isVisible = true

        drivingRouter = DirectionsFactory.getInstance().createDrivingRouter()
        mapObjects = mapView.map.mapObjects.addCollection()
        submitRequest()

        return binding.root
    }



    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onDrivingRoutes(p0: MutableList<DrivingRoute>) {
        for (route in  p0) {
            mapObjects!!.addPolyline(route.geometry)
        }
    }

    override fun onDrivingRoutesError(p0: Error) {
        val errorMessage = "Неизвестная ошибка"
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun submitRequest() {
        val drivingOptions = DrivingOptions()
        val vehicleOptions = VehicleOptions()
        val requestPoint:ArrayList<RequestPoint> = ArrayList()
        requestPoint.add(RequestPoint(START_ROAD, RequestPointType.WAYPOINT, null))
        requestPoint.add(RequestPoint(END_ROUTE, RequestPointType.WAYPOINT, null))
        drivingSession = drivingRouter!!.requestRoutes(requestPoint, drivingOptions, vehicleOptions, this)
    }
}