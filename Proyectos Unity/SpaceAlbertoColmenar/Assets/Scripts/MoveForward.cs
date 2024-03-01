using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveForward : MonoBehaviour
{
    public string direction = "bottom";

    public float speed = 4f;
    
    void Update()
    {
        /*
        Vector2 pos = transform.position;
        // para ir para abajo
        if (direction == "bottom")
        {
            pos = new Vector2(pos.x, pos.y - speed * Time.deltaTime);
        } else if (direction == "top")
        {
            pos = new Vector2(pos.x, pos.y + speed * Time.deltaTime);
        }

        //pos.y += pos.y * speed * Time.deltaTime;

        //para ir para arriba
        
        transform.position = pos;
        */
        Vector3 pos = transform.position;
        if (direction == "bottom")
        {
            Vector3 velocity = new Vector3(0, -speed * Time.deltaTime, 0);
            pos += transform.rotation * velocity;
        } else 
        {
            Vector3 velocity = new Vector3(0, speed * Time.deltaTime, 0);
            pos += transform.rotation * velocity;
        }
        
        transform.position = pos;
    }
}
