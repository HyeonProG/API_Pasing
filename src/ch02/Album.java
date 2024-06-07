package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 
{
  "userId": 1,
  "id": 1,
  "title": "quidem molestiae enim"
}
 */
// DTO 클래스 -- data transfer object
// private --> Gson lib --> 변수에 접근해서 json 값을 넣어준다.
// setter가 필요하다.

@Setter
@Getter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 필드 전체 생성자
@ToString
public class Album {
	
	private int userId;
	private int id;
	private String title;

}
