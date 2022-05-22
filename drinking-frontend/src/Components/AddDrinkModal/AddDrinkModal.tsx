import {
  Button,
  Card,
  CardBody,
  CardTitle,
  Form,
  FormFeedback,
  FormGroup,
  Input,
  Label,
  List,
  ListGroup,
  ListGroupItem,
} from "reactstrap";
import UnauthenticatedNavbar from "../../Navbars/UnauthenticatedNavbar";
import { yupResolver } from "@hookform/resolvers/yup";
import { addDrinkSchema } from "./AddDrinkSchema";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import { User } from "../../Model/User";
import { ADD_DRINK_TO_RESTAURANT, POST_USER } from "../../api-routes";
import { useForm } from "react-hook-form";
import { Restaurant } from "../../Model/Restaurant";
import { Drink } from "../../Model/Drink";
import { useEffect, useState } from "react";
import DrinkTaste from "../DrinkTaste/DrinkTaste";
import DrinkIngredients from "../DrinkIngredients/DrinkIngredients";

// toast.configure();
const AddDrinkModal = (props : {restaurant: Restaurant}) => {
  const customId = "addDrinkModal";
  const [hot, setHot] = useState(false);
  const [alcoholic, setAlcoholic] = useState(false);
  const [caffeine, setCaffeine] = useState(false);
  const [ingredients, setIngredients] = useState<string[]>([]);
  const [taste, setTaste] = useState<any>({
    'SWEET' : 0,
    'SOUR' : 0,
    'BITTER' : 0,
    'UMAMI' : 0,
    'SALTY' : 0
  });

  useEffect(() => {

  }, [])

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(addDrinkSchema),
    mode: "onChange",
  });

  const addDrink = (drink: Drink) => {
      drink.hot = hot;
      drink.alcoholic = alcoholic;
      drink.caffeine = caffeine;
      drink.taste = taste;
      drink.ingredients = ingredients;

      axios
      .put(ADD_DRINK_TO_RESTAURANT + props.restaurant.id, drink)
      .then((res: any) => {
        
      })
      .catch((err: any) => {});
  };

  const changeTaste = (flavour: string, tasteValue: number) => {
    let copy = taste;
    copy[flavour] = tasteValue;
    setTaste(copy);
  }

  const addIngredient = (ingredient: string) => {
    let copy = ingredients;

    if(!copy.find(i => i === ingredient)){
      copy.push(ingredient);
      console.log(copy);
      setIngredients(copy);
    }
  } 

  return (
    <div>
      <Card
        className="card-add-drink"
        style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
      >
        <CardBody>
          <div className="drink-basic">
            <Form >
              <FormGroup>
                <Label>Name</Label>
                <Input
                  type="text"
                  name="name"
                  placeholder="name"
                  invalid={errors.name?.message}
                  innerRef={register}
                />
                <FormFeedback>{errors.name?.message}</FormFeedback>
              </FormGroup>

              <FormGroup>
                <Label>Hot</Label>
                <Input
                  type="checkbox"
                  name="hot"
                  innerRef={register}
                  onChange={()=>setHot(!hot)}
                />
              </FormGroup>

              <FormGroup>
                <Label>Alcoholic</Label>
                <Input
                  type="checkbox"
                  name="alcoholic"
                  innerRef={register}
                  onChange={()=>setAlcoholic(!alcoholic)}
                />
              </FormGroup>

              <FormGroup>
                <Label>Caffeine</Label>
                <Input
                  type="checkbox"
                  name="caffeine"
                  innerRef={register}
                  onChange={()=>setCaffeine(!caffeine)}
                />
              </FormGroup>

              <FormGroup>
                      <Label>Texture</Label>
                      <Input type="select" name="texture" innerRef={register}>
                        <option>LIQUID</option>
                        <option>HALF_THICC</option>
                        <option>THICC</option>
                      </Input>
              </FormGroup>
            </Form>

            <div className="drink-tastes">
                <DrinkTaste changeTastes={changeTaste}/>
            </div>
          </div>

          <div className="div-ingredients">
              <DrinkIngredients addIngredient={addIngredient}/>
                <ListGroup>
                  {ingredients.map(ingredient => (
                    <ListGroupItem key={ingredient}>
                      {ingredient}
                    </ListGroupItem>
                  ))}
                </ListGroup>
          </div>

          <Button
              className="registruj-login-btn"
              color="primary"
              type="button"
              onClick={handleSubmit(addDrink)}
            >
              Add Drink
            </Button>
        </CardBody>
      </Card>
    </div>
  );
};
export default AddDrinkModal;
