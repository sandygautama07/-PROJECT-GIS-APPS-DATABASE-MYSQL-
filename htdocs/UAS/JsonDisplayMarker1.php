<?php
require_once("connection.php");
class JsonDisplayMarker1 {
	function getMarkers(){
		//untuk koneksinya
		$connection = new Connection();
		$conn = $connection->getConnection();
		//untuk respon
		$response = array();
		$code = "code";
		$message = "message";
		try{
			//menampilkan semua data dari database
			$queryMarker = "SELECT * FROM restaurant1811500042";
			$getData = $conn->prepare($queryMarker);
			$getData->execute();
			$result = $getData->fetchAll(PDO::FETCH_ASSOC);
			foreach($result as $data){
				array_push($response,
					array(
						'nama'=>$data['nama'],
						'latitude'=>$data['latitude'],
						'longitude'=>$data['longitude'])
					);
			}
		}catch (PDOException $e){
			echo "Failed displaying data".$e->getMessage();
		}
		//untuk kondisi jika berhasil atau tidaknya
		if($queryMarker){
			echo json_encode(
				array("data"=>$response,$code=>1,$message=>"Success")
			);
		}else{
			echo json_encode(
				array("data"=>$response,$code=>0,$message=>"Failed displaying data")
			);
		}
	}
}
$location = new JsonDisplayMarker1();
$location->getMarkers();
?>