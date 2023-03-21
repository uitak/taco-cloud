package tacos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
// final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만든다.
@RequiredArgsConstructor
// 인자가 없는 기본 생성자를 생성한다.
// 초기값 세팅이 필요한 final 필드가 있을 경우 컴파일 에러가 발생한다.
// (force=true) 옵션을 사용하면, final 필드를 {0, false, null} 등으로 초기화 시켜준다.
// (access=AccessLevel.PRIVATE) 생성자의 접근 제한자를 private으로 한다.
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {

	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
