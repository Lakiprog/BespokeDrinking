import * as yup from "yup";

export const createQuestionSchema = yup.object().shape({
	text: yup.string().required("Question text is required!"),
	firstAnswerText: yup.string().required("First answer text is required!"),
	firstAnswerValue: yup
		.number()
		.typeError("Please enter a valid number")
		.min(0, "Minimum at least 0"),
	secondAnswerText: yup.string().required("Second answer text is required!"),
	secondAnswerValue: yup
		.number()
		.typeError("Please enter a valid number")
		.min(0, "Minimum at least 0"),
});
