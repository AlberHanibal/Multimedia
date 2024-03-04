using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveForward : MonoBehaviour
{
    public string direction = "bottom";

    public float speed = 4f;
    
    void Update()
    {
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
