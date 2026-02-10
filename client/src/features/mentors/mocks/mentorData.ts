import type { MentorCardProps } from "../../../types/mentor";
import belfort from "../../../assets/belfort.jpg";

export const mentorCards:MentorCardProps[] = [
    {
        name: "John",
        speciality: ["e-commerce"],
        price: 50
    },
    {
        name: "Jordan Belfort",
        avatarUrl: belfort,
        speciality: ["Stocks", "Trading"],
        price: 60
    },
    {
        name: "Jorge",
        speciality: ["Individual growth", "Personal Branding"],
        price: 55
    }
]