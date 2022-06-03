import {
	Button,
	Card,
	CardBody,
	CardTitle,
	Collapse,
	Form,
	FormGroup,
	Input,
	Label,
} from "reactstrap";
import "react-toastify/dist/ReactToastify.css";
import { useState } from "react";

const FilterDrinks = (props: { filter: Function }) => {
	const [name, setName] = useState<string>("");
	const [restaurant, setRestaurant] = useState<string>("");
	const [ingredient, setIngredient] = useState<string>("");
	const [alcoholic, setAlcoholic] = useState<boolean | null>(null);
	const [caffeine, setCaffeine] = useState<boolean | null>(null);
	const [hot, setHot] = useState<boolean | null>(null);

	const [isOpen, setIsOpen] = useState(false);
	const customId = "filterDrinks";
	const selectValues = ["ALL", "YES", "NO"];

	const getSelectValue = (value: string) => {
		if (value === "ALL") {
			return null;
		} else if (value === "YES") {
			return true;
		}
		return false;
	};

	return (
		<div>
			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<CardTitle tag="h2">Filter drinks</CardTitle>

					<Button
						className="inline"
						color="primary"
						onClick={() => setIsOpen(!isOpen)}
						style={{
							marginBottom: "1rem",
						}}
					>
						Toggle
					</Button>

					<Collapse isOpen={isOpen}>
						<Form className="form-login-registracija">
							<FormGroup>
								<Label>Name</Label>
								<Input
									type="text"
									name="name"
									onChange={(event) => setName(event.target.value)}
								/>
							</FormGroup>

							<FormGroup>
								<Label>Restaurant name</Label>
								<Input
									type="text"
									name="restaurant"
									onChange={(event) => setRestaurant(event.target.value)}
								/>
							</FormGroup>

							<FormGroup>
								<Label>Contains ingredient</Label>
								<Input
									type="text"
									name="ingredient"
									onChange={(event) => setIngredient(event.target.value)}
								/>
							</FormGroup>

							<FormGroup>
								<Label>Alcoholic</Label>
								<Input
									type="select"
									name="alcoholic"
									onChange={(event) =>
										setAlcoholic(getSelectValue(event.target.value))
									}
								>
									{selectValues.map((value) => (
										<option>{value}</option>
									))}
								</Input>
							</FormGroup>

							<FormGroup>
								<Label>Caffeine</Label>
								<Input
									type="select"
									name="caffeine"
									onChange={(event) =>
										setCaffeine(getSelectValue(event.target.value))
									}
								>
									{selectValues.map((value) => (
										<option>{value}</option>
									))}
								</Input>
							</FormGroup>

							<FormGroup>
								<Label>Hot</Label>
								<Input
									type="select"
									name="hot"
									onChange={(event) =>
										setHot(getSelectValue(event.target.value))
									}
								>
									{selectValues.map((value) => (
										<option>{value}</option>
									))}
								</Input>
							</FormGroup>

							<Button
								className="registruj-login-btn"
								color="primary"
								type="button"
								onClick={() =>
									props.filter(
										name,
										restaurant,
										ingredient,
										alcoholic,
										caffeine,
										hot
									)
								}
							>
								Filter
							</Button>
						</Form>
					</Collapse>
				</CardBody>
			</Card>
		</div>
	);
};
export default FilterDrinks;
