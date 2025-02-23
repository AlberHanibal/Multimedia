using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class DamageHandler : MonoBehaviour
{
    public int health = 1;
    public float invulnPeriod = 0;
    public GameObject explosionGO;
    public bool explotable = false;

    float invulnTimer = 0;
    int correctLayer;

    void Start()
    {
        correctLayer = gameObject.layer;
    }

    void OnTriggerEnter2D()
    {		
        health--;
        invulnTimer = invulnPeriod;
        gameObject.layer = 8; // invulnerable
    }

    void Update()
    {
        invulnTimer -= Time.deltaTime;
        if (invulnTimer <= 0)
        {
            gameObject.layer = correctLayer;
        }

        if (health <= 0)
        {
            Die();
        }
    }

    void Die()
    {
        if (explotable)
        {
            GameObject explosion = (GameObject)Instantiate(explosionGO);
            explosion.transform.position = transform.position;
        }
        Destroy(gameObject);
    }
}
