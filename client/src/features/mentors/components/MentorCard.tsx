import type { MentorCardProps } from "../../../types/mentor";
import DefaultUserPic from "../../../assets/defaultUserPic.jpg";
import { useNavigate } from "react-router";

const MentorCard = ({id, name, avatarUrl, speciality, price}: MentorCardProps) => {
    const imageSrc = avatarUrl || DefaultUserPic;
    const navigate = useNavigate();

    const handleCardClick = () => {
        console.log(`Navegando al perfil de ${name}...`);
        navigate(`/mentor/${id}`);
    }

    return (
        <div
            onClick={handleCardClick}
            className="h-full border border-3 border-[#9ACCF1] backdrop-blur-xs rounded-4xl overflow-hidden max-w-xs font-cinzel text-[#0B5976]
                        cursor-pointer transition-all duration-300 hover:shadow-xl hover:scale-[1.02] active:scale-[0.98]">
            <div className="h-full flex flex-col items-center">
                <div className="max-w-[100%] ">
                    <img
                        src={imageSrc}
                        alt={name}
                        className="w-full h-full object-cover aspect-video"
                    />
                </div>

                <div className="w-[100%] flex flex-col text-left p-5 tracking-[0.1em] gap-1">
                    <h2 className="font-bold text-3xl">{name}</h2>
                    <div className="flex flex-wrap gap-2 items-start content-start overflow-hidden h-24 ">
                        {speciality.map((spec, index) =>(
                            <h3
                                key={index}
                                className="font-bold text-sm border-2 px-3 py-1 border-[#9ACCF1] rounded-xl whitespace-nonwrap"
                            >
                                {spec}
                            </h3>
                        ))}
                    </div>
                </div>

                <div className="w-[100%] h-max flex flex-col text-right p-5">
                    <span className="font-bold text-3xl">Precio/h:</span>
                    <p className="font-bold text-3xl">{price} €</p>
                </div>

            </div>
        </div>
    );
}


export default MentorCard;