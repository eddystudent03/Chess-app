import React,{useState} from 'react'

export default function Piece({type, onClick}){
    let imagesource = `../assets/${type}.jpg`
    let pieceType = type

    const handleClick = () => {
        onClick(pieceType)
    }
    return(<>
                <img src={imagesource} alt="piece" onClick={handleClick}/>
           </>)
}