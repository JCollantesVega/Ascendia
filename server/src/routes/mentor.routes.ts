import { Router } from "express";
import { getMentors } from "../controllers/mentor.controller.ts";


const router = Router();

router.get("/", getMentors);


export default router;