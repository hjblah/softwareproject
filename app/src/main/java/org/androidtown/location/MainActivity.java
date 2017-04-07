package org.androidtown.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    SupportMapFragment mapFragment;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map); //추가한 프래그먼트 참조
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "GoogleMap is ready.");

                map = googleMap;//구글맵 로딩
            }
        });

        try {
            MapsInitializer.initialize(this);
        } catch(Exception e) {
            e.printStackTrace();
        }

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() { //버튼을 누르면
            @Override
            public void onClick(View v) {
                requestMyLocation(); //위치찾기 함수 실행
            }
        });

    }

    private void requestMyLocation() {//위치요청 객체
        LocationManager manager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            long minTime = 0; //실시간
            float minDistance = 0;
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            showCurrentLocation(location);
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    } //로케이션 리스너
            );

            Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                showCurrentLocation(lastLocation);
            }

            manager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            showCurrentLocation(location);
                        }
                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }
                        @Override
                        public void onProviderEnabled(String provider) {
                        }
                        @Override
                        public void onProviderDisabled(String provider) {
                        }
                    }
            );
        } catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    private void showCurrentLocation(Location location) {
        /*LatLng curPoint = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions optFirst = new MarkerOptions(); //위치에 마크
        optFirst.position(curPoint);// 위도,경도
        optFirst.title("Current Position");// 제목
        optFirst.snippet("Snippet");//작은설명
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15)); // 카메라 높이 15 축척*/

        //기존 마커 지우기
        map.clear();
        LatLng curPosition = new LatLng(location.getLatitude(), location.getLongitude());

        //currentPosition 위치로 카메라 중심을 옮기고 화면 줌을 조정한다. 줌범위는 2~21, 숫자클수록 확대
        map.moveCamera(CameraUpdateFactory.newLatLngZoom( curPosition, 17));
        map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);

        //마커 추가
        map.addMarker(new MarkerOptions()
                .position(curPosition)
                .snippet("보조")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                .title("현재위치"));
    }
    /*private void markposition {
        double latitude =
        double longitude = gps.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Showing the current location in Google Map
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Map 을 zoom 합니다.
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(13));

        // 마커 설정.
    }*/
}
