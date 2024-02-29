using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveForward : MonoBehaviour
{
    float speed = 4f;
    
    void Update()
    {
        Vector2 pos = transform.position;
        // para ir para abajo
        //pos.y += pos.y * speed * Time.deltaTime;

        //para ir para arriba
        pos = new Vector2(pos.x, pos.y + speed * Time.deltaTime);
        transform.position = pos;
    }
}
