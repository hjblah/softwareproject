package org.androidtown.location;

import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    SupportMapFragment mapFragment;
    GoogleMap map;
    /*Marker selectedMarker;*/
    /*String Position; //현재위치를 알려주는 전역변수 추가*/

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
                bulidingMarkerItems();//호관마커그리기
                //markBulidingPosition();
                map.setOnMarkerClickListener(new OnMarkerClickListener() { //마크클릭 이벤트
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        for(int i=1; i<=10; i++) {
                            if (marker.getTitle().equals(i+"호관")) {
                                Context mContext = getApplicationContext();
                                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                                if (i == 1) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding1, (ViewGroup) findViewById(R.id.buliding1));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 2) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding2, (ViewGroup) findViewById(R.id.buliding2));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 3) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding3, (ViewGroup) findViewById(R.id.buliding3));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 4) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding4, (ViewGroup) findViewById(R.id.buliding4));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 5) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding5, (ViewGroup) findViewById(R.id.buliding5));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 6) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding6, (ViewGroup) findViewById(R.id.buliding6));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 7) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding7, (ViewGroup) findViewById(R.id.buliding7));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 8) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding8, (ViewGroup) findViewById(R.id.buliding8));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 9) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding9, (ViewGroup) findViewById(R.id.buliding9));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                                if (i == 10) {
                                    //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                                    View layout = inflater.inflate(R.layout.buliding10, (ViewGroup) findViewById(R.id.buliding10));
                                    AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                                    aDialog.setTitle(i + "호관 설명"); //타이틀바 제목
                                    aDialog.setView(layout);
                                    //닫기버튼
                                    aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    //팝업창 생성
                                    AlertDialog ad = aDialog.create();
                                    ad.show();//보여줌!
                                }
                            }
                        }
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
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        final Context mContext = getApplicationContext();
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        button.setOnClickListener(new View.OnClickListener() { //검색 버튼을 누르면
            public void onClick(View v) {
                View layout = inflater.inflate(R.layout.searchpage, (ViewGroup) findViewById(R.id.searchpage));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                aDialog.setTitle("검색"); //타이틀바 제목
                aDialog.setView(layout); //파일을 뷰로 셋팅
                //닫기버튼
                aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //팝업창 생성
                AlertDialog ad = aDialog.create();
                ad.show();//보여줌!
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){ //식단표 버튼을 누르면
            public void onClick(View v){
                View layout = inflater.inflate(R.layout.todayfood, (ViewGroup) findViewById(R.id.todayfood));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                aDialog.setTitle("식단표"); //타이틀바 제목
                aDialog.setView(layout); //파일을 뷰로 셋팅
                //닫기버튼
                aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //팝업창 생성
                AlertDialog ad = aDialog.create();
                ad.show();//보여줌!
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){ //버스시간표 버튼을 누르면
            public void onClick(View v){
                View layout = inflater.inflate(R.layout.bustable, (ViewGroup) findViewById(R.id.bustable));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                aDialog.setTitle("버스시간표"); //타이틀바 제목
                aDialog.setView(layout); //파일을 뷰로 셋팅
                //닫기버튼
                aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //팝업창 생성
                AlertDialog ad = aDialog.create();
                ad.show();//보여줌!
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){ //시설이용버튼을 누르면
            public void onClick(View v){
                View layout = inflater.inflate(R.layout.usefacility, (ViewGroup) findViewById(R.id.usefacility));
                AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                aDialog.setTitle("시설이용정보"); //타이틀바 제목
                aDialog.setView(layout); //파일을 뷰로 셋팅
                //닫기버튼
                aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //팝업창 생성
                AlertDialog ad = aDialog.create();
                ad.show();//보여줌!
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
   public class MarkerItem {
       double lat;
       double lon;
       String num;
       public MarkerItem(double lat, double lon, String num) {
           this.lat = lat; this.lon = lon;
           this.num = num;
       }
       public double getLat() {
           return lat;
       }
       public void setLat(double lat) {
           this.lat = lat;
       } public double getLon() {
           return lon;
       } public void setLon(double lon) {
           this.lon = lon;
       } public String getNum() {
           return num;
       } public void setNum(String num) {
           this.num = num;
       }
   }


   private Marker addMarker(MarkerItem markerItem) {

       LatLng position = new LatLng(markerItem.getLat(), markerItem.getLon());
       String num = markerItem.getNum();

       /*tv_marker.setText(formatted);

       if (isSelectedMarker) {
           tv_marker.setBackgroundResource(R.drawable.ic_marker_phone_blue);
           tv_marker.setTextColor(Color.WHITE);
       } else {
           tv_marker.setBackgroundResource(R.drawable.ic_marker_phone);
           tv_marker.setTextColor(Color.BLACK);
       }*/

       MarkerOptions markerOptions = new MarkerOptions();
       markerOptions.title(num);
       markerOptions.position(position);
       markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

       return map.addMarker(markerOptions); //클릭시 마커 옵션이 보이게해줌
   }

    private void bulidingMarkerItems() { ArrayList<MarkerItem> bulidingList = new ArrayList();
        bulidingList.add(new MarkerItem(36.376764,128.1454148,"1호관"));
        bulidingList.add(new MarkerItem(36.377887,128.1461390,"2호관"));
        bulidingList.add(new MarkerItem(36.379204,128.1459733,"3호관"));
        bulidingList.add(new MarkerItem(36.378552,128.1468471,"4호관"));
        bulidingList.add(new MarkerItem(36.379049,128.1467612,"5호관"));
        bulidingList.add(new MarkerItem(36.379714,128.1478127,"6호관"));
        bulidingList.add(new MarkerItem(36.379256,128.1450714,"7호관"));
        bulidingList.add(new MarkerItem(36.380318,128.1457581,"8호관"));
        bulidingList.add(new MarkerItem(36.380785,128.1448515,"9호관"));
        bulidingList.add(new MarkerItem(36.379485,128.1437679,"10호관"));
        for (MarkerItem markerItem : bulidingList) {
            addMarker(markerItem).showInfoWindow();
        }
    }

   /*private void markBulidingPosition() { //각호관 마크
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
    }*/
}
