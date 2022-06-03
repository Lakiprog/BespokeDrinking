import { Card, CardBody, CardTitle, Label, Table } from "reactstrap";
import "react-toastify/dist/ReactToastify.css";
import { Drink } from "../../Model/Drink";
import { Restaurant } from "../../Model/Restaurant";
import { DrinkDTO } from "../../Model/DrinkDTO";

// toast.configure();
const DrinksTable = (props: {
	drinks: DrinkDTO[];
	restaurant: Restaurant | null;
}) => {
	const customId = "drinksTable";

	return (
		<div>
			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<CardTitle tag="h2">Recommendations</CardTitle>

					{props.drinks.length > 0 && (
						<>
							<Table bordered className="div-dokumenti">
								<thead>
									<tr>
										<th>Name</th>
										<th>Restaurant</th>
										<th>City</th>
									</tr>
								</thead>

								<tbody>
									{props.drinks.map((drink) => {
										return (
											<tr key={drink.id}>
												<td>{drink.name}</td>
												<td>{drink.restaurant}</td>
												<td>{drink.city}</td>
											</tr>
										);
									})}
								</tbody>
							</Table>

							<Label>The restaurant that is the best fit for you is {props.restaurant?.name} which is located in {props.restaurant?.city}</Label>
						</>
					)}

					{props.drinks.length === 0 && (
						<Label>There are no drinks that fit your taste</Label>
					)}
				</CardBody>
			</Card>
		</div>
	);
};
export default DrinksTable;
