package telran.imagga.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Color {
	@JsonAlias({ "background_colors" })
	List<BackgroundColor> backgroundColors;
	@JsonAlias({"foreground_colors"})
	List<ForegroundColor> foregroundColors;
	@JsonAlias({"image_colors"})
	List<ImageColor> imageColors;
}
