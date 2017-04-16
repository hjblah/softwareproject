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
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener; //마커클릭리스너

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    SupportMapFragment mapFragment;
    GoogleMap map;


    LatLng curPosition; //현재위치를 알려주는 전역변수 추가

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
                /*map.setMapType(GoogleMap.MAP_TYPE_NORMAL);*/
                //requestMyLocation(); //위치요청 객체 실행 (GPS를 통해 실시간 위치정보를 받아옴)
                LatLng startPosition = new LatLng(36.3779780,128.1451680); // 시작위치 위경도(학교)
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(startPosition, 17));
                map.setMyLocationEnabled(true);//현재위치를 보여주는 google에서 제공하는 api
                markBulidingPosition();
                map.setOnMarkerClickListener(new OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {

                        Toast.makeText(MainActivity.this, "Oh my god!!", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }); // 마커 클릭이벤트
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
                /*map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPosition, 17)); //버튼을 눌렀을때만 카메라가 움직이도록 설정*/
            }
        });

    }


   /* private void requestMyLocation() {//위치요청 객체
        LocationManager manager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            long minTime = 0; //10000에서 실시간으로 변경
            float minDistance = 0;
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            markCurrentLocation(location);
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
                markCurrentLocation(lastLocation);
            }

            manager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            markCurrentLocation(location);
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
    }*/
    /*private void markCurrentLocation(Location location) {

        MarkerOptions optFirst = new MarkerOptions(); //위치에 마크
        optFirst.position(curPoint);// 위도,경도
        optFirst.title("Current Position");// 제목
        optFirst.snippet("Snippet");//작은설명
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15)); // 카메라 높이 15 축척
        //currentPosition 위치로 카메라 중심을 옮기고 화면 줌을 조정
        // /*map.moveCamera(CameraUpdateFactory.newLatLngZoom( curPosition, 17));
        /*map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
        curPosition = new LatLng(location.getLatitude(), location.getLongitude());
        //기존 마커 지우기
        map.clear();
        //마커 추가
        map.addMarker(new MarkerOptions()
                .position(curPosition)
                .snippet("보조")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .title("현재위치"));
    }*/


    private void markBulidingPosition() { //각호관 마크
        LatLng bulid1 = new LatLng(36.3767643,128.1454148);
        map.addMarker(new MarkerOptions()
                .position(bulid1)
                .snippet("보조")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                .title("1호관"));
        LatLng bulid2 = new LatLng(36.3778873,128.1461390);
        map.addMarker(new MarkerOptions()
                .position(bulid2)
                .snippet("보조")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                .title("2호관"));
        LatLng bulid9 = new LatLng(36.3807853,128.1448515);//잘못됨
        map.addMarker(new MarkerOptions()
                .position(bulid9)
                .snippet("보조")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                .title("3호관"));
        LatLng bulid4 = new LatLng(36.378552,128.1468471);
        map.addMarker(new MarkerOptions()
                .position(bulid4)
                .snippet("보조")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                .title("4호관"));
    }
}
