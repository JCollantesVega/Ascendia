import type { MentorCardProps } from "../../../types/mentor";
import DefaultUserPic from "../../../assets/defaultUserPic.jpg";

const MentorCard = ({name, avatarUrl, speciality, price}: MentorCardProps) => {
    return (
        <div className="border border-3 border-[#9ACCF1] backdrop-blur-xs rounded-4xl overflow-hidden max-w-xs font-cinzel text-[#0B5976]">
            <div className="flex flex-col items-center">
                <div className="max-w-[100%] ">
                    {avatarUrl ? (
                    <img
                        src={avatarUrl}
                        alt={name}
                        className="max-w-[100%] object-cover "
                    />
                    ) : (
                        <img
                            src={DefaultUserPic}
                            alt={name}
                            className="max-w-[100%] object-cover"
                        />
                    )}
                </div>

                <div className="w-[100%] flex flex-col text-left p-5 tracking-[0.1em]">
                    <h2 className="font-bold text-3xl">{name}</h2>
                    <h3 className="font-bold text-xl">{speciality}</h3>
                </div>

                <div className="w-[100%] flex flex-col text-right p-5">
                    <p className="font-bold text-3xl">Precio/h:</p>
                    <p className="font-bold text-3xl">{price} €</p>
                </div>

            </div>
        </div>
    );
}


export default MentorCard;