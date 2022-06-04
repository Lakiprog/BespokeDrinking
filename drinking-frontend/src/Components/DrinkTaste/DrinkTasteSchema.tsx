import * as yup from "yup";

export const drinkTasteSchema = yup.object().shape({
	sweet: yup
		.number()
		.typeError("Please enter a valid number")
		.min(0, "Minimum at least 0"),
	sour: yup
		.number()
		.typeError("Please enter a valid number")
		.min(0, "Minimum at least 0"),
	bitter: yup
		.number()
		.typeError("Please enter a valid number")
		.min(0, "Minimum at least 0"),
	salty: yup
		.number()
		.typeError("Please enter a valid number")
		.min(0, "Minimum at least 0"),
	umami: yup
		.number()
		.typeError("Please enter a valid number")
		.min(0, "Minimum at least 0"),
});
