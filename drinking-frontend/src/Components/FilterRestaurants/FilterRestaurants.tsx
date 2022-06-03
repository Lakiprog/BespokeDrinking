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

const FilterRestaurants = (props: { filter: Function }) => {
	const [name, setName] = useState<string>("");
	const [city, setCity] = useState<string>("");
	const [isOpen, setIsOpen] = useState(false);
	const customId = "filterRestaurants";

	return (
		<div>
			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<CardTitle tag="h2">Filter restaurants</CardTitle>

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
								<Label>City</Label>
								<Input
									type="text"
									name="city"
									onChange={(event) => setCity(event.target.value)}
								/>
							</FormGroup>

							<Button
								className="registruj-login-btn"
								color="primary"
								type="button"
								onClick={() => props.filter(name, city)}
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
export default FilterRestaurants;
