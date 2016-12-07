import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.shapes.Circle;
import com.lynden.gmapsfx.shapes.CircleOptions;

public class MapGenerator implements MapComponentInitializedListener{

	GoogleMapView mapView;
	GoogleMap map;
	
	Marker marker;
	Circle circle;
	
	public MapGenerator() {
		mapView = new GoogleMapView();
		mapView.addMapInializedListener(this);
	}
	
	public GoogleMapView getMapView() {
		return mapView;
	}
	
	public LatLong getCenter() {
		return map.getCenter();
	}
	
	public void setCenter(LatLong loc) {
		map.setCenter(loc);
	}
	
	public void setZoom(int scale) {
		map.setZoom(scale);
	}
	
	public void setMarker(LatLong loc) {
		
		marker.setPosition(loc);
		marker.setVisible(true);

	}
	
	public void setCircle(LatLong loc) {
		
		circle.setCenter(loc);
		circle.setVisible(true);

	}
	
	@Override
	public void mapInitialized() {
		// TODO Auto-generated method stub
		MapOptions mapOptions = new MapOptions();

		mapOptions
		.center(new LatLong(47.6097, -122.3331))
		.overviewMapControl(false)
		.panControl(false)
		.rotateControl(false)
		.scaleControl(false)
		.streetViewControl(false)
		.zoomControl(false)
		.mapTypeControl(false)
		.zoom(5);

		map = mapView.createMap(mapOptions);
		
		MarkerOptions markerOptions = new MarkerOptions();
		markerOptions
		.visible(false)
		.title("Location");
		marker = new Marker( markerOptions );
		map.addMarker(marker);
		
		CircleOptions circleOptions = new CircleOptions();
		circleOptions
		.fillColor("gray")
		.fillOpacity(0.20)
		.visible(false)
		.strokeColor("gray")
		.radius(241401.6); //150 MILE
		
		circle = new Circle(circleOptions);
		map.addMapShape(circle);
	
	}

}
