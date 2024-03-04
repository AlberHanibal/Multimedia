using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SelfDestruct : MonoBehaviour
{
    public float timer = 1f;

    void Update()
    {
        timer -= Time.deltaTime;
        Vector2 maxBot = Camera.main.ViewportToWorldPoint(new Vector2(0, -2.2f));
        if (timer <= 0 || transform.position.y == maxBot.y)
        {
            Destroy(gameObject);
        }
    }

    void DestroyGameObject()
    {
        Destroy(gameObject);
    }
}
