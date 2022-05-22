import * as yup from "yup";

export const drinkTasteSchema = yup.object().shape({
  sweet: yup
    .number()
    .typeError("Please enter a valid number")
    .min(0, "Minimum at least 0")
    .max(10, "Allowed maximum is 10"),
  sour: yup
    .number()
    .typeError("Please enter a valid number")
    .min(0, "Minimum at least 0")
    .max(10, "Allowed maximum is 10"),
  bitter: yup
    .number()
    .typeError("Please enter a valid number")
    .min(0, "Minimum at least 0")
    .max(10, "Allowed maximum is 10"),
  salty: yup
    .number()
    .typeError("Please enter a valid number")
    .min(0, "Minimum at least 0")
    .max(10, "Allowed maximum is 10"),
  umami: yup
    .number()
    .typeError("Please enter a valid number")
    .min(0, "Minimum at least 0")
    .max(10, "Allowed maximum is 10"),
});
