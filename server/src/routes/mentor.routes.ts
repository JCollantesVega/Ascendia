import { Router } from "express";
import { getMentors } from "../controllers/mentor.controller.js";
import { QuicEndpoint } from "node:quic";


const router = Router();

router.get("/", getMentors);


export default router;