package org.androidtown.location;

import android.content.ClipData;
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
    int count = 0;
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
                LatLng startPosition = new LatLng(36.3779780,128.1451680); // 시작위치 위경도(학교)
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(startPosition, 17));
                map.setMyLocationEnabled(true);//현재위치를 보여주는 google에서 제공하는 api
                bulidingMarkerItems();//호관마커그리기
                map.setOnMarkerClickListener(new OnMarkerClickListener() { //마크클릭 이벤트
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Context mContext = getApplicationContext();
                        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                        for(int i=1; i<=10; i++) {
                            if (marker.getTitle().equals(i+"호관")) {
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
                        if (marker.getTitle().equals("대운동장")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.playground, (ViewGroup) findViewById(R.id.playground));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("대운동장 설명"); //타이틀바 제목
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
                        if (marker.getTitle().equals("도서관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.book, (ViewGroup) findViewById(R.id.book));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("도서관 설명"); //타이틀바 제목
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
                        if (marker.getTitle().equals("복지회관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.studentstore, (ViewGroup) findViewById(R.id.studentstore));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("복지회관 설명"); //타이틀바 제목
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
                        if (marker.getTitle().equals("학생회관,학생식당")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.studentfacility, (ViewGroup) findViewById(R.id.studentfacility));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("학생회관,학생식당"); //타이틀바 제목
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
                        if (marker.getTitle().equals("창조관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.domchang, (ViewGroup) findViewById(R.id.domchang));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("기숙사"); //타이틀바 제목
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
                        if (marker.getTitle().equals("경애관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.domkyung, (ViewGroup) findViewById(R.id.domkyung));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("기숙사"); //타이틀바 제목
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
                        if (marker.getTitle().equals("근면관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.domgun, (ViewGroup) findViewById(R.id.domgun));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("기숙사"); //타이틀바 제목
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
                        if (marker.getTitle().equals("자주관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.domja, (ViewGroup) findViewById(R.id.domja));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("기숙사"); //타이틀바 제목
                            aDialog.setView(layout);
                            //닫기버튼
                            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            //팝업창 생성
                            AlertDialog ad = aDialog.create();
                            ad.show();//보여줌!
                        }if (marker.getTitle().equals("청운관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.domchung, (ViewGroup) findViewById(R.id.domchung));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("기숙사"); //타이틀바 제목
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
                        if (marker.getTitle().equals("노악관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.domno, (ViewGroup) findViewById(R.id.domno));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("기숙사"); //타이틀바 제목
                            aDialog.setView(layout);
                            //닫기버튼
                            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            //팝업창 생성
                            AlertDialog ad = aDialog.create();
                            ad.show();//보여줌!
                        }if (marker.getTitle().equals("체육관")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.gym, (ViewGroup) findViewById(R.id.gym));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("체육관"); //타이틀바 제목
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
                        if (marker.getTitle().equals("테니스장")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.tennis, (ViewGroup) findViewById(R.id.tennis));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("테니스장"); //타이틀바 제목
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
                        if (marker.getTitle().equals("풋살장")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.football, (ViewGroup) findViewById(R.id.football));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("풋살장"); //타이틀바 제목
                            aDialog.setView(layout);
                            //닫기버튼
                            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            //팝업창 생성
                            AlertDialog ad = aDialog.create();
                            ad.show();//보여줌!
                        }if (marker.getTitle().equals("산학연종합지원센터")){ //R.layout.buliding1는 xml 파일명  R.id.buliding1은 보여줄 레이아웃 아이디
                            View layout = inflater.inflate(R.layout.supply, (ViewGroup) findViewById(R.id.supply));
                            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
                            aDialog.setTitle("산학연종합지원센터"); //타이틀바 제목
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
                /*View layout = inflater.inflate(R.layout.usefacility, (ViewGroup) findViewById(R.id.usefacility));
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
                ad.show();//보여줌!*/
                if(count == 0) {
                    count++;
                    map.clear();
                }
                else if (count == 1)
                {
                    count--;
                    bulidingMarkerItems();
                }
            }
        });
    }
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
   public void clearMark(){
       map.clear();
       MarkerOptions markerOptions = new MarkerOptions();
   }
   private Marker addMarker(MarkerItem markerItem) {
       LatLng position = new LatLng(markerItem.getLat(), markerItem.getLon());
       String num = markerItem.getNum();
       MarkerOptions markerOptions = new MarkerOptions();
       markerOptions.title(num);
       markerOptions.position(position);
       markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
       //map.addMarker(markerOptions).showInfoWindow();
       return map.addMarker(markerOptions); //클릭시 마커 옵션이 보이게해줌
   }
    private Marker blueMarker(MarkerItem markerItem) {
        LatLng position = new LatLng(markerItem.getLat(), markerItem.getLon());
        String num = markerItem.getNum();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title(num);
        markerOptions.position(position);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        //map.addMarker(markerOptions).showInfoWindow();
        return map.addMarker(markerOptions); //클릭시 마커 옵션이 보이게해줌
    }

    private void bulidingMarkerItems() { ArrayList<MarkerItem> bulidingList = new ArrayList(); ArrayList<MarkerItem> facilityList = new ArrayList<>();
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

        facilityList.add(new MarkerItem(36.376323,128.1461175,"대운동장"));
        facilityList.add(new MarkerItem(36.379204,128.1436338,"도서관"));
        facilityList.add(new MarkerItem(36.378673,128.1447603,"복지회관"));
        facilityList.add(new MarkerItem(36.378008,128.1438162,"학생회관,학생식당"));
        facilityList.add(new MarkerItem(36.378671,128.1479611,"풋살장"));
        facilityList.add(new MarkerItem(36.378861,128.1481711,"테니스장"));
        facilityList.add(new MarkerItem(36.375361,128.1447311,"체육관"));
        facilityList.add(new MarkerItem(36.378431,128.1427808,"산학연종합지원센터"));

        facilityList.add(new MarkerItem(36.377494,128.1435909,"창조관"));
        facilityList.add(new MarkerItem(36.376971,128.1437035,"자주관"));
        facilityList.add(new MarkerItem(36.377066,128.1431724,"근면관"));
        facilityList.add(new MarkerItem(36.377451,128.1427969,"경애관"));
        facilityList.add(new MarkerItem(36.377751,128.1423211,"노악관"));
        facilityList.add(new MarkerItem(36.378051,128.1422611,"청운관"));

        facilityList.add(new MarkerItem(36.380161,128.1469511,"파워플랜트"));
        facilityList.add(new MarkerItem(36.380711,128.1464011,"파일럿플랜트"));
        facilityList.add(new MarkerItem(36.379591,128.1490011,"기계실습실"));
        facilityList.add(new MarkerItem(36.379901,128.1490111,"자동차실습동"));
        facilityList.add(new MarkerItem(36.380121,128.1491311,"섬유공장"));

        for (MarkerItem markerItem : bulidingList) {
            addMarker(markerItem);
            //addMarker(markerItem).showInfoWindow(); //마커옵션이 항상보이게
        }
        for (MarkerItem markerItem : facilityList){
            blueMarker(markerItem);
        }
    }
}
