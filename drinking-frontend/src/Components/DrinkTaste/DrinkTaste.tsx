import { Form, FormFeedback, FormGroup, Input, Label } from "reactstrap";
import "react-toastify/dist/ReactToastify.css";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { drinkTasteSchema } from "./DrinkTasteSchema";

// toast.configure();
const DrinkTaste = (props: { changeTastes: Function }) => {
	const customId = "drinkTaste";

	const {
		register,
		handleSubmit,
		formState: { errors },
	} = useForm({
		resolver: yupResolver(drinkTasteSchema),
		mode: "onChange",
	});

	return (
		<Form className="form-login-registracija">
			<FormGroup>
				<Label>Sweet</Label>
				<Input
					type="number"
					name="sweet"
					defaultValue={0}
					min="0"
					placeholder="0"
					onChange={(event) => props.changeTastes("SWEET", event.target.value)}
					invalid={errors.sweet?.message}
					innerRef={register}
				/>
				<FormFeedback>{errors.sweet?.message}</FormFeedback>
			</FormGroup>

			<FormGroup>
				<Label>Sour</Label>
				<Input
					type="number"
					name="sour"
					defaultValue={0}
					min="0"
					placeholder="0"
					onChange={(event) => props.changeTastes("SOUR", event.target.value)}
					invalid={errors.sour?.message}
					innerRef={register}
				/>
				<FormFeedback>{errors.sour?.message}</FormFeedback>
			</FormGroup>

			<FormGroup>
				<Label>Bitter</Label>
				<Input
					type="number"
					name="bitter"
					defaultValue={0}
					min="0"
					placeholder="0"
					onChange={(event) => props.changeTastes("BITTER", event.target.value)}
					invalid={errors.bitter?.message}
					innerRef={register}
				/>
				<FormFeedback>{errors.bitter?.message}</FormFeedback>
			</FormGroup>

			<FormGroup>
				<Label>Salty</Label>
				<Input
					type="number"
					name="salty"
					defaultValue={0}
					min="0"
					placeholder="0"
					onChange={(event) => props.changeTastes("SALTY", event.target.value)}
					invalid={errors.salty?.message}
					innerRef={register}
				/>
				<FormFeedback>{errors.salty?.message}</FormFeedback>
			</FormGroup>

			<FormGroup>
				<Label>Umami</Label>
				<Input
					type="number"
					name="umami"
					defaultValue={0}
					min="0"
					placeholder="0"
					onChange={(event) => props.changeTastes("UMAMI", event.target.value)}
					invalid={errors.umami?.message}
					innerRef={register}
				/>
				<FormFeedback>{errors.umami?.message}</FormFeedback>
			</FormGroup>
		</Form>
	);
};
export default DrinkTaste;
